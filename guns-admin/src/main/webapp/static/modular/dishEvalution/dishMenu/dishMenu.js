/**
 * 评价管理管理初始化
 */
var DishMenu = {
    id: "DishMenuTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DishMenu.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '饭店id', field: 'restaurantId', visible: true, align: 'center', valign: 'middle'},
            {title: '饭店名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '消费时间', field: 'oederTime', visible: true, align: 'center', valign: 'middle'},
            {title: '消费总额', field: 'amount', visible: true, align: 'center', valign: 'middle'},
            {title: '是否有效', field: 'yn', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'status', visible: true, align: 'center', valign: 'middle'},
            {title: '修改人', field: 'moidfiedUser', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createdTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'modifiedTime', visible: true, align: 'center', valign: 'middle'},
            {title: '备注', field: 'remark', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
DishMenu.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DishMenu.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加评价管理
 */
DishMenu.openAddDishMenu = function () {
    var index = layer.open({
        type: 2,
        title: '添加评价管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dishMenu/dishMenu_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看评价管理详情
 */
DishMenu.openDishMenuDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '评价管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dishMenu/dishMenu_update/' + DishMenu.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除评价管理
 */
DishMenu.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/dishMenu/delete", function (data) {
            Feng.success("删除成功!");
            DishMenu.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("dishMenuId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询评价管理列表
 */
DishMenu.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DishMenu.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DishMenu.initColumn();
    var table = new BSTable(DishMenu.id, "/dishMenu/list", defaultColunms);
    table.setPaginationType("client");
    DishMenu.table = table.init();
});

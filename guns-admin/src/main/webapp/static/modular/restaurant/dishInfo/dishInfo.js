/**
 * 饭店管理管理初始化
 */
var DishInfo = {
    id: "DishInfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
DishInfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '饭店id', field: 'restaurantId', visible: true, align: 'center', valign: 'middle'},
            {title: '菜名', field: 'dishName', visible: true, align: 'center', valign: 'middle'},
            {title: '种类', field: 'type', visible: true, align: 'center', valign: 'middle'},
            {title: '菜品图片', field: 'picture', visible: true, align: 'center', valign: 'middle'},
            {title: '口味', field: 'tasty', visible: true, align: 'center', valign: 'middle'},
            {title: '单价', field: 'price', visible: true, align: 'center', valign: 'middle'},
            {title: '平均得分', field: 'averageScore', visible: true, align: 'center', valign: 'middle'},
            {title: '评价次数', field: 'scoreTimes', visible: true, align: 'center', valign: 'middle'},
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
DishInfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        DishInfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加饭店管理
 */
DishInfo.openAddDishInfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加饭店管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/dishInfo/dishInfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看饭店管理详情
 */
DishInfo.openDishInfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '饭店管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/dishInfo/dishInfo_update/' + DishInfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除饭店管理
 */
DishInfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/dishInfo/delete", function (data) {
            Feng.success("删除成功!");
            DishInfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("dishInfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询饭店管理列表
 */
DishInfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    DishInfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = DishInfo.initColumn();
    var table = new BSTable(DishInfo.id, "/dishInfo/list", defaultColunms);
    table.setPaginationType("client");
    DishInfo.table = table.init();
});

/**
 * 饭店管理管理初始化
 */
var Restaurant = {
    id: "RestaurantTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Restaurant.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '饭店名称', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '饭店地址', field: 'address', visible: true, align: 'center', valign: 'middle'},
            {title: '店主', field: 'onwer', visible: true, align: 'center', valign: 'middle'},
            {title: '规模', field: 'scale', visible: true, align: 'center', valign: 'middle'},
            {title: '联系电话', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '用户id', field: 'userId', visible: true, align: 'center', valign: 'middle'},
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
Restaurant.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Restaurant.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加饭店管理
 */
Restaurant.openAddRestaurant = function () {
    var index = layer.open({
        type: 2,
        title: '添加饭店管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/restaurant/restaurant_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看饭店管理详情
 */
Restaurant.openRestaurantDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '饭店管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/restaurant/restaurant_update/' + Restaurant.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除饭店管理
 */
Restaurant.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/restaurant/delete", function (data) {
            Feng.success("删除成功!");
            Restaurant.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("restaurantId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询饭店管理列表
 */
Restaurant.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Restaurant.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Restaurant.initColumn();
    var table = new BSTable(Restaurant.id, "/restaurant/list", defaultColunms);
    table.setPaginationType("client");
    Restaurant.table = table.init();
});

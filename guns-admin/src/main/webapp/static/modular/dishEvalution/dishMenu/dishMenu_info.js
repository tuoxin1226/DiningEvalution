/**
 * 初始化评价管理详情对话框
 */
var DishMenuInfoDlg = {
    dishMenuInfoData : {}
};

/**
 * 清除数据
 */
DishMenuInfoDlg.clearData = function() {
    this.dishMenuInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DishMenuInfoDlg.set = function(key, val) {
    this.dishMenuInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DishMenuInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DishMenuInfoDlg.close = function() {
    parent.layer.close(window.parent.DishMenu.layerIndex);
}

/**
 * 收集数据
 */
DishMenuInfoDlg.collectData = function() {
    this
    .set('id')
    .set('restaurantId')
    .set('name')
    .set('oederTime')
    .set('amount')
    .set('yn')
    // .set('status')
    // .set('moidfiedUser')
    // .set('createdTime')
    // .set('modifiedTime')
    // .set('remark');
}

/**
 * 提交添加
 */
DishMenuInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dishMenu/add", function(data){
        Feng.success("添加成功!");
        window.parent.DishMenu.table.refresh();
        DishMenuInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dishMenuInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DishMenuInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dishMenu/update", function(data){
        Feng.success("修改成功!");
        window.parent.DishMenu.table.refresh();
        DishMenuInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dishMenuInfoData);
    ajax.start();
}

$(function() {

});

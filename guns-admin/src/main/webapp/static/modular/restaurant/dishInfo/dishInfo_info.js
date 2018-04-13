/**
 * 初始化饭店管理详情对话框
 */
var DishInfoInfoDlg = {
    dishInfoInfoData : {}
};

/**
 * 清除数据
 */
DishInfoInfoDlg.clearData = function() {
    this.dishInfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DishInfoInfoDlg.set = function(key, val) {
    this.dishInfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
DishInfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
DishInfoInfoDlg.close = function() {
    parent.layer.close(window.parent.DishInfo.layerIndex);
}

/**
 * 收集数据
 */
DishInfoInfoDlg.collectData = function() {
    this
    .set('id')
    .set('restaurantId')
    .set('dishName')
    .set('type')
    .set('picture')
    .set('tasty')
    .set('price');
    // .set('averageScore')
    // .set('scoreTimes')
    // .set('yn')
    // .set('status')
    // .set('moidfiedUser')
    // .set('createdTime')
    // .set('modifiedTime')
    // .set('remark');
}

/**
 * 提交添加
 */
DishInfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dishInfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.DishInfo.table.refresh();
        DishInfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dishInfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
DishInfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/dishInfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.DishInfo.table.refresh();
        DishInfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.dishInfoInfoData);
    ajax.start();
}

$(function() {

});

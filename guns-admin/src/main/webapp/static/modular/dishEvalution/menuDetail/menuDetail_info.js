/**
 * 初始化评价管理详情对话框
 */
var MenuDetailInfoDlg = {
    menuDetailInfoData : {}
};

/**
 * 清除数据
 */
MenuDetailInfoDlg.clearData = function() {
    this.menuDetailInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MenuDetailInfoDlg.set = function(key, val) {
    this.menuDetailInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
MenuDetailInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
MenuDetailInfoDlg.close = function() {
    parent.layer.close(window.parent.MenuDetail.layerIndex);
}

/**
 * 收集数据
 */
MenuDetailInfoDlg.collectData = function() {
    this
    .set('id')
    .set('menuId')
    .set('dishId')
    .set('dishName')
    .set('score')
    .set('appraise')
    .set('price')
    .set('yn')
    .set('status')
    .set('moidfiedUser')
    .set('createdTime')
    .set('modifiedTime')
    .set('remark');
}

/**
 * 提交添加
 */
MenuDetailInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/menuDetail/add", function(data){
        Feng.success("添加成功!");
        window.parent.MenuDetail.table.refresh();
        MenuDetailInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.menuDetailInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
MenuDetailInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/menuDetail/update", function(data){
        Feng.success("修改成功!");
        window.parent.MenuDetail.table.refresh();
        MenuDetailInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.menuDetailInfoData);
    ajax.start();
}

$(function() {

});

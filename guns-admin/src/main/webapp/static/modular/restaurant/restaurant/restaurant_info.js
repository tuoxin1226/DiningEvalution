/**
 * 初始化饭店管理详情对话框
 */
var RestaurantInfoDlg = {
    restaurantInfoData : {}
};

/**
 * 清除数据
 */
RestaurantInfoDlg.clearData = function() {
    this.restaurantInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RestaurantInfoDlg.set = function(key, val) {
    this.restaurantInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
RestaurantInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
RestaurantInfoDlg.close = function() {
    parent.layer.close(window.parent.Restaurant.layerIndex);
}

/**
 * 收集数据
 */
RestaurantInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('address')
    .set('onwer')
    .set('scale')
    .set('phone')
    // .set('userId')
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
RestaurantInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/restaurant/add", function(data){
        Feng.success("添加成功!");
        window.parent.Restaurant.table.refresh();
        RestaurantInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.restaurantInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
RestaurantInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/restaurant/update", function(data){
        Feng.success("修改成功!");
        window.parent.Restaurant.table.refresh();
        RestaurantInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.restaurantInfoData);
    ajax.start();
}

$(function() {

});

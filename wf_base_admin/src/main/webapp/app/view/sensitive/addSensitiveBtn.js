    Ext.define("WF.view.sensitive.addSensitiveBtn", {
    extend: "Ext.Button",
    alias: "addSensitiveBtn",
    text : '新增',
    iconCls : 'icon-add',//样式请参考webapp/resources/css/icon.css
    listeners : {
        click : function() {
            var main = Ext.ComponentQuery.query("sensitiveMain")[0];
            var doRefresh = main.down('datagrid').store;
            var win = Ext.create("WF.view.sensitive.addSensitive", {doRefresh: doRefresh});
            win.show();
        }
    }
});
    Ext.define("WF.view.dict.addDictBtn", {
    extend: "Ext.Button",
    alias: "addDictBtn",
    text : '新增',
    iconCls : 'icon-add',//样式请参考webapp/resources/css/icon.css
    listeners : {
        click : function() {
            var main = Ext.ComponentQuery.query("dictMain")[0];
            var doRefresh = main.down('datagrid').store;
            var win = Ext.create("WF.view.dict.addDict", {doRefresh: doRefresh});
            win.show();
        }
    }
});
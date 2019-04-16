    Ext.define("WF.view.channel.addChannelBtn", {
    extend: "Ext.Button",
    alias: "addChannelBtn",
    text : '新增',
    iconCls : 'icon-add',//样式请参考webapp/resources/css/icon.css
    listeners : {
        click : function() {
            var main = Ext.ComponentQuery.query("channelMain")[0];
            var doRefresh = main.down('datagrid').store;
            var win = Ext.create("WF.view.channel.addChannel", {doRefresh: doRefresh});
            win.show();
        }
    }
});
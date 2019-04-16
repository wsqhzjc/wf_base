Ext.define('WF.view.channel.addChannel', {
    extend: 'Ext.window.Window',
    alias: 'addChannel',
    title: '新增',
    modal: true,
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    initComponent: function () {
        this.callParent(arguments);
        var me = this;
        me.add({
            xtype: 'dataform',
            baseCls: 'x-plain',
            border: true,
            columns: 2,
            items: [{
                allowBlank: true,
                name: 'id',
                colspan: 2,
                xtype: 'numberfield',
                fieldLabel: '渠道编码'
            }, {
                afterLabelTextTpl: required,
                allowBlank: false,
                name: 'code',
                colspan: 2,
                fieldLabel: '渠道Code'
            }, {
                afterLabelTextTpl: required,
                allowBlank: false,
                name: 'name',
                colspan: 2,
                fieldLabel: '渠道名称'
            }, {
                afterLabelTextTpl: required,
                allowBlank: false,
                name: 'description',
                colspan: 2,
                fieldLabel: '渠道描述'
            }, {
                colspan: 2,
                name: 'parentId',
                xtype: 'searchfield',
                emptyText: "",
                displayField: 'name',
                valueField: "id",
                editable: false,
                queryMode: "local",
                store: 'channelStore',
                fieldLabel: '父渠道'
            }, {
                afterLabelTextTpl: required,
                allowBlank: false,
                xtype: 'radiogroup',
                colspan: 2,
                fieldLabel: '是否启用',
                items: [{boxLabel: '是', name: 'enable', inputValue: '1'},
                    {boxLabel: '否', name: 'enable', inputValue: '0'}]
            }]
        });
    },
    buttons: [{
        text: '保存',
        iconCls: "icon-ok",
        handler: function () {
            var currentWindow = this.up('window');
            var form = currentWindow.down('dataform').getForm();
            if (!form.isValid()) {
                return;
            }
            var doRefresh = currentWindow.doRefresh;
            callapi("base/admin/channel/save.do", form.getValues(),
                function (result) {
                    if (result.success) {
                        Ext.MessageBox.show({
                            title: "提示",
                            msg: "保存成功",
                            modal: true,
                            icon: Ext.Msg.INFO,
                            buttons: Ext.Msg.OK
                        });
                        doRefresh.reload();
                        currentWindow.close();
                    }
                    else {
                        Ext.Msg.show({
                            title: '错误',
                            msg: result.data.msg,
                            buttons: Ext.Msg.OK,
                            icon: Ext.MessageBox.ERROR,
                            modal: true
                        });
                    }
                });
        }
    }]
});
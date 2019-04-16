Ext.define('WF.view.channel.channelMain', {
    extend: 'Ext.panel.Panel',
    title: '渠道管理',
    xtype: 'channelMain',
    closable: true,
    layout: {
        type: 'vbox',
        align: 'stretch'
    },
    initComponent: function () {
        this.callParent(arguments);
        var me = this;
        var store = Ext.create('DCIS.Store', {
            autoLoad: true,
            url: 'base/admin/channel/list.do',
            fields: ['id', 'parentId', 'name', 'code', 'description', 'enable']
        });
        me.add({
            border: false,
            store: store,
            xtype: 'searchpanel',
            title: '查询',
            collapsible: true,
            collapsed: false,
            columns: 2,
            buildField: "Manual",
            forceFit: true,
            items: [{
                name: 'id',
                fieldLabel: '渠道编码'
            }]
        });
        me.add({
            xtype: 'datagrid',
            store: store,
            buildField: "Manual",
            forceFit: true,
            columns: [{
                text: '渠道编码',
                dataIndex: 'id',
                width: 80,
                menuDisabled: true,
                sortable: false
            }, {
                text: '父渠道',
                dataIndex: 'parentId',
                width: 80,
                menuDisabled: true,
                sortable: false
            }, {
                text: '渠道Code',
                dataIndex: 'code',
                width: 80,
                menuDisabled: true,
                sortable: false
            }, {
                text: '渠道名称',
                width: 100,
                dataIndex: 'name',
                menuDisabled: true,
                sortable: false
            }, {
                text: '渠道描述',
                width: 120,
                dataIndex: 'description',
                menuDisabled: true,
                sortable: false
            }, {
                text: '是否启用',
                dataIndex: 'enable',
                width: 80,
                menuDisabled: true,
                sortable: false,
                renderer: function (value) {
                    return value === 1 ? "是" : "否";
                }
            }]
        });
    }
});
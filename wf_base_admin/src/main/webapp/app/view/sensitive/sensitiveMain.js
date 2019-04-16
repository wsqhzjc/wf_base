Ext.define('WF.view.sensitive.sensitiveMain', {
    extend: 'Ext.panel.Panel',
    title: '字典管理管理',
    xtype: 'sensitiveMain',
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
            url: 'base/admin/sensitive/list.do',
            fields: ['id', 'content', 'createTime']
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
                name: 'content',
                fieldLabel: '敏感词'
            }]
        });
        me.add({
            xtype: 'datagrid',
            store: store,
            buildField: "Manual",
            forceFit: true,
            columns: [{
                text: 'ID',
                dataIndex: 'id',
                width: 80,
                menuDisabled: true,
                sortable: false
            }, {
                text: '内容',
                width: 100,
                dataIndex: 'content',
                menuDisabled: true,
                sortable: false
            }, {
                text: '添加时间',
                width: 120,
                dataIndex: 'createTime',
                menuDisabled: true,
                sortable: false
            }]
        });
    }
});
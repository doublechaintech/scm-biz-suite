import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"双链小超", menuFor: "retailStore",
  		subItems: [
  {name: 'consumerOrderList', displayName:'消费者订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'retailStoreOrderList', displayName:'生超的订单', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'transportTaskList', displayName:'运输任务', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountSetList', displayName:'账套', icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"双链小超", menuFor: "retailStore",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  telephone: '电话',
  owner: '业主',
  retailStoreCountryCenter: '双链小超全国运营中心',
  cityServiceCenter: '城市服务中心',
  creation: '创建',
  investmentInvitation: '招商',
  franchising: '加盟',
  decoration: '装修',
  opening: '开业',
  closing: '关闭',
  founded: '成立',
  latitude: '纬度',
  longitude: '经度',
  description: '描述',
  lastUpdateTime: '最后更新时间',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'retailStore') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.telephone, debugtype: 'string', dataIndex: 'telephone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.owner, debugtype: 'string', dataIndex: 'owner', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.retailStoreCountryCenter, dataIndex: 'retailStoreCountryCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.cityServiceCenter, dataIndex: 'cityServiceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.creation, dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.investmentInvitation, dataIndex: 'investmentInvitation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.franchising, dataIndex: 'franchising', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.decoration, dataIndex: 'decoration', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.opening, dataIndex: 'opening', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.closing, dataIndex: 'closing', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '25',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '22',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(retailStore,targetComponent)=>{

  const userContext = null
  return (
    <div key={retailStore.id}>
	
      <DescriptionList  key={retailStore.id} size="small" col="4">
        <Description term="序号">{retailStore.id}</Description> 
        <Description term="名称">{retailStore.name}</Description> 
        <Description term="电话">{retailStore.telephone}</Description> 
        <Description term="业主">{retailStore.owner}</Description> 
        <Description term="城市服务中心"><div>{retailStore.cityServiceCenter==null?appLocaleName(userContext,"NotAssigned"):`${retailStore.cityServiceCenter.displayName}(${retailStore.cityServiceCenter.id})`}
        </div></Description>
        <Description term="成立"><div>{ moment(retailStore.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term="纬度"><div style={{"color":"red"}}>{retailStore.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{retailStore.longitude}</div></Description> 
        <Description term="描述">{retailStore.description}</Description> 
        <Description term="最后更新时间"><div>{ moment(retailStore.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="当前状态">{retailStore.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const RetailStoreBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreBase




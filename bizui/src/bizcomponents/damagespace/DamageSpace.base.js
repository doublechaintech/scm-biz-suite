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


const menuData = {menuName:"残次货物存放区", menuFor: "damageSpace",
  		subItems: [
  {name: 'goodsShelfList', displayName:'货架', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  location: '位置',
  contactNumber: '联系电话',
  totalArea: '总面积',
  latitude: '纬度',
  longitude: '经度',
  warehouse: '仓库',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'damageSpace') , sorter: true },
  { title: fieldLabels.location, debugtype: 'string', dataIndex: 'location', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.totalArea, debugtype: 'string', dataIndex: 'totalArea', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.warehouse, dataIndex: 'warehouse', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(damageSpace,targetComponent)=>{

  const userContext = null
  return (
    <div key={damageSpace.id}>
	
      <DescriptionList  key={damageSpace.id} size="small" col="4">
        <Description term="序号">{damageSpace.id}</Description> 
        <Description term="位置">{damageSpace.location}</Description> 
        <Description term="联系电话">{damageSpace.contactNumber}</Description> 
        <Description term="总面积">{damageSpace.totalArea}</Description> 
        <Description term="纬度"><div style={{"color":"red"}}>{damageSpace.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{damageSpace.longitude}</div></Description> 
        <Description term="仓库"><div>{damageSpace.warehouse==null?appLocaleName(userContext,"NotAssigned"):`${damageSpace.warehouse.displayName}(${damageSpace.warehouse.id})`}
        </div></Description>
        <Description term="最后更新时间"><div>{ moment(damageSpace.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const DamageSpaceBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default DamageSpaceBase




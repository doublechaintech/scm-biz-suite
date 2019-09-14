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


const menuData = {menuName:"货物移动", menuFor: "goodsMovement",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  moveTime: '移动时间',
  facility: '设施',
  facilityId: '设备ID',
  fromIp: '从IP',
  userAgent: '用户代理',
  sessionId: '会话ID',
  latitude: '纬度',
  longitude: '经度',
  goods: '货物',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'goodsMovement') , sorter: true },
  { title: fieldLabels.moveTime, dataIndex: 'moveTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.facility, debugtype: 'string', dataIndex: 'facility', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.facilityId, debugtype: 'string', dataIndex: 'facilityId', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.fromIp, debugtype: 'string', dataIndex: 'fromIp', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.userAgent, debugtype: 'string', dataIndex: 'userAgent', width: '115',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.sessionId, debugtype: 'string', dataIndex: 'sessionId', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.goods, dataIndex: 'goods', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(goodsMovement,targetComponent)=>{

  const userContext = null
  return (
    <div key={goodsMovement.id}>
	
      <DescriptionList  key={goodsMovement.id} size="small" col="4">
        <Description term="序号">{goodsMovement.id}</Description> 
        <Description term="移动时间"><div>{ moment(goodsMovement.moveTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="设施">{goodsMovement.facility}</Description> 
        <Description term="设备ID">{goodsMovement.facilityId}</Description> 
        <Description term="从IP">{goodsMovement.fromIp}</Description> 
        <Description term="会话ID">{goodsMovement.sessionId}</Description> 
        <Description term="纬度"><div style={{"color":"red"}}>{goodsMovement.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{goodsMovement.longitude}</div></Description> 
        <Description term="货物"><div>{goodsMovement.goods==null?appLocaleName(userContext,"NotAssigned"):`${goodsMovement.goods.displayName}(${goodsMovement.goods.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const GoodsMovementBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default GoodsMovementBase




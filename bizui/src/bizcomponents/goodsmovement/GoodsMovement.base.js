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


const menuData = {menuName:"Goods Movement", menuFor: "goodsMovement",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  moveTime: 'Move Time',
  facility: 'Facility',
  facilityId: 'Facility Id',
  fromIp: 'From Ip',
  userAgent: 'User Agent',
  sessionId: 'Session Id',
  latitude: 'Latitude',
  longitude: 'Longitude',
  goods: 'Goods',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
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
<Description term="Id">{goodsMovement.id}</Description> 
<Description term="Move Time">{ moment(goodsMovement.moveTime).format('YYYY-MM-DD')}</Description> 
<Description term="Facility">{goodsMovement.facility}</Description> 
<Description term="Facility Id">{goodsMovement.facilityId}</Description> 
<Description term="From Ip">{goodsMovement.fromIp}</Description> 
<Description term="Session Id">{goodsMovement.sessionId}</Description> 
<Description term="Latitude">{goodsMovement.latitude}</Description> 
<Description term="Longitude">{goodsMovement.longitude}</Description> 
<Description term="Goods">{goodsMovement.goods==null?appLocaleName(userContext,"NotAssigned"):`${goodsMovement.goods.displayName}(${goodsMovement.goods.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const GoodsMovementBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default GoodsMovementBase




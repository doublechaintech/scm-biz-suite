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


const menuData = {menuName:"Transport Task", menuFor: "transportTask",
  		subItems: [
  {name: 'goodsList', displayName:'Goods', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'transportTaskTrackList', displayName:'Transport Task Track', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  start: 'Start',
  beginTime: 'Begin Time',
  end: 'End',
  driver: 'Driver',
  truck: 'Truck',
  belongsTo: 'Belongs To',
  latitude: 'Latitude',
  longitude: 'Longitude',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'transportTask') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.start, debugtype: 'string', dataIndex: 'start', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.beginTime, dataIndex: 'beginTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.end, dataIndex: 'end', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.driver, dataIndex: 'driver', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.truck, dataIndex: 'truck', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.latitude, debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.longitude, debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(transportTask,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={transportTask.id}>
	
	<DescriptionList  key={transportTask.id} size="small" col="4">
<Description term="Id">{transportTask.id}</Description> 
<Description term="Name">{transportTask.name}</Description> 
<Description term="Start">{transportTask.start}</Description> 
<Description term="Begin Time">{ moment(transportTask.beginTime).format('YYYY-MM-DD')}</Description> 
<Description term="End">{transportTask.end==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.end.displayName}(${transportTask.end.id})`}
</Description>
<Description term="Driver">{transportTask.driver==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.driver.displayName}(${transportTask.driver.id})`}
</Description>
<Description term="Truck">{transportTask.truck==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.truck.displayName}(${transportTask.truck.id})`}
</Description>
<Description term="Belongs To">{transportTask.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.belongsTo.displayName}(${transportTask.belongsTo.id})`}
</Description>
<Description term="Latitude">{transportTask.latitude}</Description> 
<Description term="Longitude">{transportTask.longitude}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const TransportTaskBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TransportTaskBase




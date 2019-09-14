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


const menuData = {menuName:"运输任务", menuFor: "transportTask",
  		subItems: [
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'transportTaskTrackList', displayName:'运输任务跟踪', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  start: '开始',
  beginTime: '开始时间',
  end: '结束',
  driver: '司机',
  truck: '卡车',
  belongsTo: '属于',
  latitude: '纬度',
  longitude: '经度',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'transportTask') , sorter: true },
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
        <Description term="序号">{transportTask.id}</Description> 
        <Description term="名称">{transportTask.name}</Description> 
        <Description term="开始">{transportTask.start}</Description> 
        <Description term="开始时间"><div>{ moment(transportTask.beginTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="结束"><div>{transportTask.end==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.end.displayName}(${transportTask.end.id})`}
        </div></Description>
        <Description term="司机"><div>{transportTask.driver==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.driver.displayName}(${transportTask.driver.id})`}
        </div></Description>
        <Description term="卡车"><div>{transportTask.truck==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.truck.displayName}(${transportTask.truck.id})`}
        </div></Description>
        <Description term="属于"><div>{transportTask.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${transportTask.belongsTo.displayName}(${transportTask.belongsTo.id})`}
        </div></Description>
        <Description term="纬度"><div style={{"color":"red"}}>{transportTask.latitude}</div></Description> 
        <Description term="经度"><div style={{"color":"red"}}>{transportTask.longitude}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const TransportTaskBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default TransportTaskBase




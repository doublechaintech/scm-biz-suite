import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"城市活动", menuFor: "cityEvent",
  		subItems: [
  {name: 'eventAttendanceList', displayName:'活动的参与情况', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('city_event'), menuFor: "cityEvent",
  		subItems: [
  {name: 'eventAttendanceList', displayName: window.mtrans('event_attendance','city_event.event_attendance_list',false), type:'eventAttendance',icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('city_event'), menuFor: "cityEvent",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('city_event.id'),
  name: window.trans('city_event.name'),
  mobile: window.trans('city_event.mobile'),
  cityServiceCenter: window.trans('city_event.city_service_center'),
  description: window.trans('city_event.description'),
  lastUpdateTime: window.trans('city_event.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'cityEvent') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.cityServiceCenter, dataIndex: 'cityServiceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(cityEvent,targetComponent)=>{

  const userContext = null
  return (
    <div key={cityEvent.id}>
	
      <DescriptionList  key={cityEvent.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{cityEvent.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{cityEvent.name}</Description> 
        <Description term={fieldLabels.mobile} style={{wordBreak: 'break-all'}}>{cityEvent.mobile}</Description> 
        <Description term={fieldLabels.cityServiceCenter}><div>{cityEvent.cityServiceCenter==null?appLocaleName(userContext,"NotAssigned"):`${cityEvent.cityServiceCenter.displayName}(${cityEvent.cityServiceCenter.id})`}
        </div></Description>
        <Description term={fieldLabels.description} style={{wordBreak: 'break-all'}}>{cityEvent.description}</Description> 
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(cityEvent.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"城市活动", menuFor: "cityEvent",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  name: '名称',
  mobile: '手机',
  cityServiceCenter: '城市服务中心',
  description: '描述',
  lastUpdateTime: '最后更新时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'cityEvent') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.cityServiceCenter, dataIndex: 'cityServiceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(cityEvent,targetComponent)=>{

  const userContext = null
  return (
    <div key={cityEvent.id}>
	
      <DescriptionList  key={cityEvent.id} size="small" col="4">
        <Description term="序号">{cityEvent.id}</Description> 
        <Description term="名称">{cityEvent.name}</Description> 
        <Description term="手机">{cityEvent.mobile}</Description> 
        <Description term="城市服务中心"><div>{cityEvent.cityServiceCenter==null?appLocaleName(userContext,"NotAssigned"):`${cityEvent.cityServiceCenter.displayName}(${cityEvent.cityServiceCenter.id})`}
        </div></Description>
        <Description term="描述">{cityEvent.description}</Description> 
        <Description term="最后更新时间"><div>{ moment(cityEvent.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobile, description, cityServiceCenterId} = formValuesToPack
	const cityServiceCenter = {id: cityServiceCenterId, version: 2^31}
	const data = {name, mobile, description, cityServiceCenter}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, mobile, description, cityServiceCenterId} = formValuesToPack
	const cityServiceCenter = {id: cityServiceCenterId, version: 2^31}
	const data = {name, mobile, description, cityServiceCenter}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, mobile, description, cityServiceCenter} = objectToUnpack
	const cityServiceCenterId = cityServiceCenter ? cityServiceCenter.id : null
	const data = {name, mobile, description, cityServiceCenterId}
	return data
}
<<<<<<< HEAD

const CityEventBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const CityEventBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default CityEventBase




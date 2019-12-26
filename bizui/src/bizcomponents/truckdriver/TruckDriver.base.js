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
const menuData = {menuName:"卡车司机", menuFor: "truckDriver",
  		subItems: [
  {name: 'transportTaskList', displayName:'运输任务', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('truck_driver'), menuFor: "truckDriver",
  		subItems: [
  {name: 'transportTaskList', displayName: window.mtrans('transport_task','truck_driver.transport_task_list',false), type:'transportTask',icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('truck_driver'), menuFor: "truckDriver",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('truck_driver.id'),
  name: window.trans('truck_driver.name'),
  driverLicenseNumber: window.trans('truck_driver.driver_license_number'),
  contactNumber: window.trans('truck_driver.contact_number'),
  belongsTo: window.trans('truck_driver.belongs_to'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'truckDriver') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.driverLicenseNumber, debugtype: 'long', dataIndex: 'driverLicenseNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string_china_mobile_phone', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(truckDriver,targetComponent)=>{

  const userContext = null
  return (
    <div key={truckDriver.id}>
	
      <DescriptionList  key={truckDriver.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{truckDriver.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{truckDriver.name}</Description> 
        <Description term={fieldLabels.driverLicenseNumber}><div style={{"color":"red"}}>{truckDriver.driverLicenseNumber}</div></Description> 
        <Description term={fieldLabels.contactNumber} style={{wordBreak: 'break-all'}}>{truckDriver.contactNumber}</Description> 
        <Description term={fieldLabels.belongsTo}><div>{truckDriver.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${truckDriver.belongsTo.displayName}(${truckDriver.belongsTo.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"卡车司机", menuFor: "truckDriver",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: '序号',
  name: '名称',
  driverLicenseNumber: '驾驶执照号码',
  contactNumber: '联系电话',
  belongsTo: '属于',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'truckDriver') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.driverLicenseNumber, debugtype: 'string', dataIndex: 'driverLicenseNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.contactNumber, debugtype: 'string_china_mobile_phone', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(truckDriver,targetComponent)=>{

  const userContext = null
  return (
    <div key={truckDriver.id}>
	
      <DescriptionList  key={truckDriver.id} size="small" col="4">
        <Description term="序号">{truckDriver.id}</Description> 
        <Description term="名称">{truckDriver.name}</Description> 
        <Description term="驾驶执照号码">{truckDriver.driverLicenseNumber}</Description> 
        <Description term="联系电话">{truckDriver.contactNumber}</Description> 
        <Description term="属于"><div>{truckDriver.belongsTo==null?appLocaleName(userContext,"NotAssigned"):`${truckDriver.belongsTo.displayName}(${truckDriver.belongsTo.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, driverLicenseNumber, contactNumber, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, driverLicenseNumber, contactNumber, belongsTo}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, driverLicenseNumber, contactNumber, belongsToId} = formValuesToPack
	const belongsTo = {id: belongsToId, version: 2^31}
	const data = {name, driverLicenseNumber, contactNumber, belongsTo}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, driverLicenseNumber, contactNumber, belongsTo} = objectToUnpack
	const belongsToId = belongsTo ? belongsTo.id : null
	const data = {name, driverLicenseNumber, contactNumber, belongsToId}
	return data
}
<<<<<<< HEAD

const TruckDriverBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const TruckDriverBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default TruckDriverBase




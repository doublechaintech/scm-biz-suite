import React from 'react'
import { Icon,Divider, Avatar, Card, Col, Tag} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
import styles from './ListAccess.base.less'
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderAvatarCell=defaultRenderAvatarCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell



const menuData = {menuName: window.trans('list_access'), menuFor: "listAccess",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('list_access'), menuFor: "listAccess",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('list_access.id'),
  name: window.trans('list_access.name'),
  internalName: window.trans('list_access.internal_name'),
  readPermission: window.trans('list_access.read_permission'),
  createPermission: window.trans('list_access.create_permission'),
  deletePermission: window.trans('list_access.delete_permission'),
  updatePermission: window.trans('list_access.update_permission'),
  executionPermission: window.trans('list_access.execution_permission'),
  app: window.trans('list_access.app'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '6', render: (text, record)=>renderTextCell(text,record,'listAccess') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.internalName, debugtype: 'string', dataIndex: 'internalName', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.readPermission, debugtype: 'bool', dataIndex: 'readPermission', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.createPermission, debugtype: 'bool', dataIndex: 'createPermission', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.deletePermission, debugtype: 'bool', dataIndex: 'deletePermission', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.updatePermission, debugtype: 'bool', dataIndex: 'updatePermission', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.executionPermission, debugtype: 'bool', dataIndex: 'executionPermission', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
const colorList = ['#f56a00', '#7265e6', '#ffbf00', '#00a2ae'];
let counter = 0;
const genColor=()=>{
	counter++;
	return colorList[counter%colorList.length];
}
const followColor=()=>{
	return 'green';
	// return colorList[counter%colorList.length];
}
const leftChars=(value, left)=>{
	const chars = left || 4
	if(!value){
		return "N/A"
	}
	return value.substring(0,chars);
}

const renderTextItem=(value, label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}
const renderImageItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	
	return <ImagePreview title={label} imageLocation={value}/>
}

const renderDateItem=(value, label,targetComponent)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return moment(value).format('YYYY-MM-DD');
}

const renderDateTimeItem=(value,label, targetComponent)=>{
	const userContext = window.userContext
	if(!value){
		return appLocaleName(userContext,"NotAssigned")
	}
	return  moment(value).format('YYYY-MM-DD HH:mm')
}


const renderReferenceItem=(value,label, targetComponent)=>{
	const userContext = null
	if(!value){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.id){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	if(!value.displayName){
		return <Tag color='red'>{appLocaleName(userContext,"NotAssigned")}</Tag>
	}
	
	return <Tag color='blue' title={`${value.displayName}(${value.id})`}>{leftChars(value.displayName)}</Tag>
}

const renderItemOfList=(listAccess, targetComponent, columCount, listName)=>{
  
  if(!listAccess){
  	return null
  }
  if(!listAccess.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`${listName}-${listAccess.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(listAccess.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={listAccess.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{listAccess.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{listAccess.name}</Description> 
        <Description term={fieldLabels.internalName} style={{wordBreak: 'break-all'}}>{listAccess.internalName}</Description> 
        <Description term={fieldLabels.readPermission} style={{wordBreak: 'break-all'}}>{listAccess.readPermission}</Description> 
        <Description term={fieldLabels.createPermission} style={{wordBreak: 'break-all'}}>{listAccess.createPermission}</Description> 
        <Description term={fieldLabels.deletePermission} style={{wordBreak: 'break-all'}}>{listAccess.deletePermission}</Description> 
        <Description term={fieldLabels.updatePermission} style={{wordBreak: 'break-all'}}>{listAccess.updatePermission}</Description> 
        <Description term={fieldLabels.executionPermission} style={{wordBreak: 'break-all'}}>{listAccess.executionPermission}</Description> 
        <Description term={fieldLabels.app}>{renderReferenceItem(listAccess.app)}</Description>

	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission, appId} = formValuesToPack
	const app = {id: appId, version: 2^31}
	const data = {name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission, app}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission, app} = objectToUnpack
	const appId = app ? app.id : null
	const data = {name, internalName, readPermission, createPermission, deletePermission, updatePermission, executionPermission, appId}
	return data
}
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
const ListAccessBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ListAccessBase


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
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'listAccess') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.internalName, debugtype: 'string', dataIndex: 'internalName', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.readPermission, dataIndex: 'readPermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.createPermission, dataIndex: 'createPermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.deletePermission, dataIndex: 'deletePermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.updatePermission, dataIndex: 'updatePermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.executionPermission, dataIndex: 'executionPermission', render: (text, record) =>renderBooleanCell(text, record), sorter:true },
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)
<<<<<<< HEAD
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
const renderItemOfList=(listAccess, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 4
=======

const renderItemOfList=(listAccess, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
>>>>>>> b1266426b024c6919f91c6b5be4635d10d614fe9
  const userContext = null
  return (
    <Card key={listAccess.id} style={{marginTop:"10px"}}>
		
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
        <Description term={fieldLabels.app}><Tag color='blue' title={`${listAccess.app.id}-${listAccess.app.displayName}`}>{listAccess.app==null?appLocaleName(userContext,"NotAssigned"):`${leftChars(listAccess.app.displayName,15)}`}
        </Tag></Description>
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, internalName, appId} = formValuesToPack
	const app = {id: appId, version: 2^31}
	const data = {name, internalName, app}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, internalName, app} = objectToUnpack
	const appId = app ? app.id : null
	const data = {name, internalName, appId}
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


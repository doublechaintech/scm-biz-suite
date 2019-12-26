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
const menuData = {menuName:"访问列表", menuFor: "listAccess",
=======

const menuData = {menuName: window.trans('list_access'), menuFor: "listAccess",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD
=======

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

const renderItemOfList=(listAccess,targetComponent)=>{

  const userContext = null
  return (
    <div key={listAccess.id}>
	
      <DescriptionList  key={listAccess.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{listAccess.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{listAccess.name}</Description> 
        <Description term={fieldLabels.internalName} style={{wordBreak: 'break-all'}}>{listAccess.internalName}</Description> 
        <Description term={fieldLabels.app}><div>{listAccess.app==null?appLocaleName(userContext,"NotAssigned"):`${listAccess.app.displayName}(${listAccess.app.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"访问列表", menuFor: "listAccess",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

const fieldLabels = {
  id: 'ID',
  name: '名称',
  internalName: '内部名称',
  readPermission: '读权限',
  createPermission: '创建权限',
  deletePermission: '删除权限',
  updatePermission: '更新权限',
  executionPermission: '执行权限',
  app: '应用程序',

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
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(listAccess,targetComponent)=>{

  const userContext = null
  return (
    <div key={listAccess.id}>
	
      <DescriptionList  key={listAccess.id} size="small" col="4">
        <Description term="ID">{listAccess.id}</Description> 
        <Description term="名称">{listAccess.name}</Description> 
        <Description term="内部名称">{listAccess.internalName}</Description> 
        <Description term="应用程序"><div>{listAccess.app==null?appLocaleName(userContext,"NotAssigned"):`${listAccess.app.displayName}(${listAccess.app.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, internalName, appId} = formValuesToPack
	const app = {id: appId, version: 2^31}
	const data = {name, internalName, app}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, internalName, appId} = formValuesToPack
	const app = {id: appId, version: 2^31}
	const data = {name, internalName, app}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, internalName, app} = objectToUnpack
	const appId = app ? app.id : null
	const data = {name, internalName, appId}
	return data
}
<<<<<<< HEAD

const ListAccessBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const ListAccessBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ListAccessBase




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
const menuData = {menuName:"对象访问", menuFor: "objectAccess",
=======

const menuData = {menuName: window.trans('object_access'), menuFor: "objectAccess",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

<<<<<<< HEAD

const settingMenuData = {menuName:"对象访问", menuFor: "objectAccess",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'ID',
  name: '名称',
  objectType: '访问对象类型',
  list1: '列表1',
  list2: '列表2',
  list3: '列表3',
  list4: '列表4',
  list5: '列表5',
  list6: '列表6',
  list7: '列表7',
  list8: '列表8',
  list9: '列表9',
  app: '应用程序',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'objectAccess') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.objectType, debugtype: 'string', dataIndex: 'objectType', width: '32',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list1, debugtype: 'string', dataIndex: 'list1', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list2, debugtype: 'string', dataIndex: 'list2', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list3, debugtype: 'string', dataIndex: 'list3', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list4, debugtype: 'string', dataIndex: 'list4', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list5, debugtype: 'string', dataIndex: 'list5', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list6, debugtype: 'string', dataIndex: 'list6', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list7, debugtype: 'string', dataIndex: 'list7', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list8, debugtype: 'string', dataIndex: 'list8', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list9, debugtype: 'string', dataIndex: 'list9', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(objectAccess,targetComponent)=>{

  const userContext = null
  return (
    <div key={objectAccess.id}>
	
      <DescriptionList  key={objectAccess.id} size="small" col="4">
        <Description term="ID">{objectAccess.id}</Description> 
        <Description term="名称">{objectAccess.name}</Description> 
        <Description term="访问对象类型">{objectAccess.objectType}</Description> 
        <Description term="列表1">{objectAccess.list1}</Description> 
        <Description term="列表2">{objectAccess.list2}</Description> 
        <Description term="列表3">{objectAccess.list3}</Description> 
        <Description term="列表4">{objectAccess.list4}</Description> 
        <Description term="列表5">{objectAccess.list5}</Description> 
        <Description term="列表6">{objectAccess.list6}</Description> 
        <Description term="列表7">{objectAccess.list7}</Description> 
        <Description term="列表8">{objectAccess.list8}</Description> 
        <Description term="列表9">{objectAccess.list9}</Description> 
        <Description term="应用程序"><div>{objectAccess.app==null?appLocaleName(userContext,"NotAssigned"):`${objectAccess.app.displayName}(${objectAccess.app.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, appId} = formValuesToPack
	const app = {id: appId, version: 2^31}
	const data = {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, app}
	return data
}
=======

const settingMenuData = {menuName: window.trans('object_access'), menuFor: "objectAccess",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('object_access.id'),
  name: window.trans('object_access.name'),
  objectType: window.trans('object_access.object_type'),
  list1: window.trans('object_access.list1'),
  list2: window.trans('object_access.list2'),
  list3: window.trans('object_access.list3'),
  list4: window.trans('object_access.list4'),
  list5: window.trans('object_access.list5'),
  list6: window.trans('object_access.list6'),
  list7: window.trans('object_access.list7'),
  list8: window.trans('object_access.list8'),
  list9: window.trans('object_access.list9'),
  app: window.trans('object_access.app'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'objectAccess') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.objectType, debugtype: 'string', dataIndex: 'objectType', width: '32',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list1, debugtype: 'string', dataIndex: 'list1', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list2, debugtype: 'string', dataIndex: 'list2', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list3, debugtype: 'string', dataIndex: 'list3', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list4, debugtype: 'string', dataIndex: 'list4', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list5, debugtype: 'string', dataIndex: 'list5', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list6, debugtype: 'string', dataIndex: 'list6', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list7, debugtype: 'string', dataIndex: 'list7', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list8, debugtype: 'string', dataIndex: 'list8', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.list9, debugtype: 'string', dataIndex: 'list9', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.app, dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(objectAccess,targetComponent)=>{

  const userContext = null
  return (
    <div key={objectAccess.id}>
	
      <DescriptionList  key={objectAccess.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{objectAccess.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{objectAccess.name}</Description> 
        <Description term={fieldLabels.objectType} style={{wordBreak: 'break-all'}}>{objectAccess.objectType}</Description> 
        <Description term={fieldLabels.list1} style={{wordBreak: 'break-all'}}>{objectAccess.list1}</Description> 
        <Description term={fieldLabels.list2} style={{wordBreak: 'break-all'}}>{objectAccess.list2}</Description> 
        <Description term={fieldLabels.list3} style={{wordBreak: 'break-all'}}>{objectAccess.list3}</Description> 
        <Description term={fieldLabels.list4} style={{wordBreak: 'break-all'}}>{objectAccess.list4}</Description> 
        <Description term={fieldLabels.list5} style={{wordBreak: 'break-all'}}>{objectAccess.list5}</Description> 
        <Description term={fieldLabels.list6} style={{wordBreak: 'break-all'}}>{objectAccess.list6}</Description> 
        <Description term={fieldLabels.list7} style={{wordBreak: 'break-all'}}>{objectAccess.list7}</Description> 
        <Description term={fieldLabels.list8} style={{wordBreak: 'break-all'}}>{objectAccess.list8}</Description> 
        <Description term={fieldLabels.list9} style={{wordBreak: 'break-all'}}>{objectAccess.list9}</Description> 
        <Description term={fieldLabels.app}><div>{objectAccess.app==null?appLocaleName(userContext,"NotAssigned"):`${objectAccess.app.displayName}(${objectAccess.app.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, appId} = formValuesToPack
	const app = {id: appId, version: 2^31}
	const data = {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, app}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, app} = objectToUnpack
	const appId = app ? app.id : null
	const data = {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, appId}
	return data
}
<<<<<<< HEAD

const ObjectAccessBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
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
const ObjectAccessBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ObjectAccessBase




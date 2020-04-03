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
import styles from './ObjectAccess.base.less'
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



const menuData = {menuName: window.trans('object_access'), menuFor: "objectAccess",
  		subItems: [
  
  		],
}


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

const renderReferenceItem=(value, targetComponent)=>{
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
	
	return <Tag color='blue' title={`${value.displayName}()`}>{leftChars(value.displayName)}</Tag>
	
	
	
	
}
const renderItemOfList=(objectAccess, targetComponent, columCount)=>{
  
  if(!objectAccess){
  	return null
  }
  if(!objectAccess.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`objectAccess-${objectAccess.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(objectAccess.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={objectAccess.id} size="small" col={displayColumnsCount} >
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
        <Description term={fieldLabels.app}>{renderReferenceItem(objectAccess.app)}</Description>

	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, appId} = formValuesToPack
	const app = {id: appId, version: 2^31}
	const data = {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, app}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, app} = objectToUnpack
	const appId = app ? app.id : null
	const data = {name, objectType, list1, list2, list3, list4, list5, list6, list7, list8, list9, appId}
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
const ObjectAccessBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ObjectAccessBase


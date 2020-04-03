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
import styles from './UiAction.base.less'
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



const menuData = {menuName: window.trans('ui_action'), menuFor: "uiAction",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('ui_action'), menuFor: "uiAction",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('ui_action.id'),
  code: window.trans('ui_action.code'),
  icon: window.trans('ui_action.icon'),
  title: window.trans('ui_action.title'),
  brief: window.trans('ui_action.brief'),
  imageUrl: window.trans('ui_action.image_url'),
  linkToUrl: window.trans('ui_action.link_to_url'),
  extraData: window.trans('ui_action.extra_data'),
  page: window.trans('ui_action.page'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'uiAction') , sorter: true },
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.icon, debugtype: 'string', dataIndex: 'icon', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.brief, debugtype: 'string', dataIndex: 'brief', width: '13',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.imageUrl, dataIndex: 'imageUrl', render: (text, record) => renderImageCell(text,record,'ui_action.image_url') },
  { title: fieldLabels.linkToUrl, debugtype: 'string', dataIndex: 'linkToUrl', width: '21',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.extraData, debugtype: 'string_longtext', dataIndex: 'extraData', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.page, dataIndex: 'page', render: (text, record) => renderReferenceCell(text, record), sorter:true},

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
const renderItemOfList=(uiAction, targetComponent, columCount)=>{
  
  if(!uiAction){
  	return null
  }
  if(!uiAction.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`uiAction-${uiAction.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(uiAction.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={uiAction.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{uiAction.id}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{uiAction.code}</Description> 
        <Description term={fieldLabels.icon} style={{wordBreak: 'break-all'}}>{uiAction.icon}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{uiAction.title}</Description> 
        <Description term={fieldLabels.brief} style={{wordBreak: 'break-all'}}>{uiAction.brief}</Description> 
        <Description term={fieldLabels.linkToUrl} style={{wordBreak: 'break-all'}}>{uiAction.linkToUrl}</Description> 
        <Description term={fieldLabels.page}>{renderReferenceItem(uiAction.page)}</Description>

	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {code, icon, title, brief, linkToUrl, pageId, extraData} = formValuesToPack
	const page = {id: pageId, version: 2^31}
	const data = {code, icon, title, brief, linkToUrl, page, extraData}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {code, icon, title, brief, linkToUrl, page, extraData} = objectToUnpack
	const pageId = page ? page.id : null
	const data = {code, icon, title, brief, linkToUrl, pageId, extraData}
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
const UiActionBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default UiActionBase


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
import styles from './Section.base.less'
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



const menuData = {menuName: window.trans('section'), menuFor: "section",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('section'), menuFor: "section",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('section.id'),
  title: window.trans('section.title'),
  brief: window.trans('section.brief'),
  icon: window.trans('section.icon'),
  viewGroup: window.trans('section.view_group'),
  linkToUrl: window.trans('section.link_to_url'),
  page: window.trans('section.page'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'section') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.brief, debugtype: 'string', dataIndex: 'brief', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.icon, debugtype: 'string', dataIndex: 'icon', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.viewGroup, debugtype: 'string', dataIndex: 'viewGroup', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.linkToUrl, debugtype: 'string', dataIndex: 'linkToUrl', width: '21',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.page, debugtype: 'string', dataIndex: 'page', width: '11',render: (text, record)=>renderTextCell(text,record)},

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
const renderItemOfList=(section, targetComponent, columCount)=>{
  
  if(!section){
  	return null
  }
  if(!section.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`section-${section.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(section.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
	  
	 
	
      <DescriptionList  key={section.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{section.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{section.title}</Description> 
        <Description term={fieldLabels.brief} style={{wordBreak: 'break-all'}}>{section.brief}</Description> 
        <Description term={fieldLabels.icon} style={{wordBreak: 'break-all'}}>{section.icon}</Description> 
        <Description term={fieldLabels.viewGroup} style={{wordBreak: 'break-all'}}>{section.viewGroup}</Description> 
        <Description term={fieldLabels.linkToUrl} style={{wordBreak: 'break-all'}}>{section.linkToUrl}</Description> 
        <Description term={fieldLabels.page} style={{wordBreak: 'break-all'}}>{section.page}</Description> 
	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, brief, icon, viewGroup, linkToUrl, page} = formValuesToPack

	const data = {title, brief, icon, viewGroup, linkToUrl, page}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, brief, icon, viewGroup, linkToUrl, page} = objectToUnpack

	const data = {title, brief, icon, viewGroup, linkToUrl, page}
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
const SectionBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SectionBase


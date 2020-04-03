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
import styles from './Page.base.less'
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



const menuData = {menuName: window.trans('page'), menuFor: "page",
  		subItems: [
  {name: 'slideList', displayName: window.mtrans('slide','page.slide_list',false), type:'slide',icon:'sliders-h',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'uiActionList', displayName: window.mtrans('ui_action','page.ui_action_list',false), type:'uiAction',icon:'building',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('page'), menuFor: "page",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('page.id'),
  pageTitle: window.trans('page.page_title'),
  linkToUrl: window.trans('page.link_to_url'),
  pageType: window.trans('page.page_type'),
  mobileApp: window.trans('page.mobile_app'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'page') , sorter: true },
  { title: fieldLabels.pageTitle, debugtype: 'string', dataIndex: 'pageTitle', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.linkToUrl, debugtype: 'string', dataIndex: 'linkToUrl', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.pageType, dataIndex: 'pageType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.mobileApp, dataIndex: 'mobileApp', render: (text, record) => renderReferenceCell(text, record), sorter:true},

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
const renderItemOfList=(page, targetComponent, columCount)=>{
  
  if(!page){
  	return null
  }
  if(!page.id){
  	return null
  }
  
  
  const displayColumnsCount = columCount || 4
  const userContext = null
  return (
    <Card key={`page-${page.id}`} style={{marginTop:"10px"}}>
		
	<Col span={4}>
		<Avatar size={90} style={{ backgroundColor: genColor(), verticalAlign: 'middle' }}>
			{leftChars(page.displayName)}
		</Avatar>
	</Col>
	<Col span={20}>
	  
		<span className={styles.stamp} style={{color:followColor(),borderColor:followColor()}} >{page.pageType.displayName}</span>	  
	  
	  
	 
	
      <DescriptionList  key={page.id} size="small" col={displayColumnsCount} >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{page.id}</Description> 
        <Description term={fieldLabels.pageTitle} style={{wordBreak: 'break-all'}}>{page.pageTitle}</Description> 
        <Description term={fieldLabels.linkToUrl} style={{wordBreak: 'break-all'}}>{page.linkToUrl}</Description> 
        <Description term={fieldLabels.pageType}>{renderReferenceItem(page.pageType)}</Description>

	
        
      </DescriptionList>
     </Col>
    </Card>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {pageTitle, linkToUrl, pageTypeId, mobileAppId} = formValuesToPack
	const pageType = {id: pageTypeId, version: 2^31}
	const mobileApp = {id: mobileAppId, version: 2^31}
	const data = {pageTitle, linkToUrl, pageType, mobileApp}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {pageTitle, linkToUrl, pageType, mobileApp} = objectToUnpack
	const pageTypeId = pageType ? pageType.id : null
	const mobileAppId = mobileApp ? mobileApp.id : null
	const data = {pageTitle, linkToUrl, pageTypeId, mobileAppId}
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
const PageBase={menuData,settingMenuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default PageBase


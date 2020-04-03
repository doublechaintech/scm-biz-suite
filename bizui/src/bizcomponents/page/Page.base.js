import React from 'react'
import { Icon,Divider, Avata, Card, Col} from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList

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

const renderItemOfList=(page, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={page.id}>
	
      <DescriptionList  key={page.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{page.id}</Description> 
        <Description term={fieldLabels.pageTitle} style={{wordBreak: 'break-all'}}>{page.pageTitle}</Description> 
        <Description term={fieldLabels.linkToUrl} style={{wordBreak: 'break-all'}}>{page.linkToUrl}</Description> 
        <Description term={fieldLabels.pageType}><div>{page.pageType==null?appLocaleName(userContext,"NotAssigned"):`${page.pageType.displayName}(${page.pageType.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
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
const PageBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default PageBase




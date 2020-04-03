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



const menuData = {menuName: window.trans('page_type'), menuFor: "pageType",
  		subItems: [
  {name: 'pageList', displayName: window.mtrans('page','page_type.page_list',false), type:'page',icon:'page4',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('page_type'), menuFor: "pageType",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('page_type.id'),
  name: window.trans('page_type.name'),
  code: window.trans('page_type.code'),
  mobileApp: window.trans('page_type.mobile_app'),
  footerTab: window.trans('page_type.footer_tab'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'pageType') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '16',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.code, debugtype: 'string', dataIndex: 'code', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobileApp, dataIndex: 'mobileApp', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.footerTab, dataIndex: 'footerTab', render: (text, record) =>renderBooleanCell(text, record), sorter:true },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(pageType, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={pageType.id}>
	
      <DescriptionList  key={pageType.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{pageType.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{pageType.name}</Description> 
        <Description term={fieldLabels.code} style={{wordBreak: 'break-all'}}>{pageType.code}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, code, mobileAppId} = formValuesToPack
	const mobileApp = {id: mobileAppId, version: 2^31}
	const data = {name, code, mobileApp}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, code, mobileApp} = objectToUnpack
	const mobileAppId = mobileApp ? mobileApp.id : null
	const data = {name, code, mobileAppId}
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
const PageTypeBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default PageTypeBase




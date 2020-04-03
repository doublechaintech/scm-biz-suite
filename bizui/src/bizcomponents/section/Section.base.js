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
  linkToUrl: window.trans('section.link_to_url'),
  page: window.trans('section.page'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'section') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.brief, debugtype: 'string', dataIndex: 'brief', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.linkToUrl, debugtype: 'string', dataIndex: 'linkToUrl', width: '21',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.page, debugtype: 'string', dataIndex: 'page', width: '11',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(section, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={section.id}>
	
      <DescriptionList  key={section.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{section.id}</Description> 
        <Description term={fieldLabels.title} style={{wordBreak: 'break-all'}}>{section.title}</Description> 
        <Description term={fieldLabels.brief} style={{wordBreak: 'break-all'}}>{section.brief}</Description> 
        <Description term={fieldLabels.linkToUrl} style={{wordBreak: 'break-all'}}>{section.linkToUrl}</Description> 
        <Description term={fieldLabels.page} style={{wordBreak: 'break-all'}}>{section.page}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, brief, linkToUrl, page} = formValuesToPack

	const data = {title, brief, linkToUrl, page}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, brief, linkToUrl, page} = objectToUnpack

	const data = {title, brief, linkToUrl, page}
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
const SectionBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default SectionBase




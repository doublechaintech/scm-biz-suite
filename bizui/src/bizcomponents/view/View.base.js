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



const menuData = {menuName: window.trans('view'), menuFor: "view",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName: window.trans('view'), menuFor: "view",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('view.id'),
  who: window.trans('view.who'),
  assessment: window.trans('view.assessment'),
  interviewTime: window.trans('view.interview_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'view') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.assessment, debugtype: 'string', dataIndex: 'assessment', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.interviewTime, dataIndex: 'interviewTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(view,targetComponent)=>{

  const userContext = null
  return (
    <div key={view.id}>
	
      <DescriptionList  key={view.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{view.id}</Description> 
        <Description term={fieldLabels.who} style={{wordBreak: 'break-all'}}>{view.who}</Description> 
        <Description term={fieldLabels.assessment} style={{wordBreak: 'break-all'}}>{view.assessment}</Description> 
        <Description term={fieldLabels.interviewTime}><div>{ moment(view.interviewTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {who, assessment, interviewTime} = formValuesToPack

	const data = {who, assessment, interviewTime}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {who, assessment, interviewTime} = objectToUnpack

	const data = {who, assessment, interviewTime}
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
const ViewBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ViewBase




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



const menuData = {menuName: window.trans('scoring'), menuFor: "scoring",
  		subItems: [
  {name: 'employeeCompanyTrainingList', displayName: window.mtrans('employee_company_training','scoring.employee_company_training_list',false), type:'employeeCompanyTraining',icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName: window.trans('scoring'), menuFor: "scoring",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('scoring.id'),
  scoredBy: window.trans('scoring.scored_by'),
  score: window.trans('scoring.score'),
  comment: window.trans('scoring.comment'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'scoring') , sorter: true },
  { title: fieldLabels.scoredBy, debugtype: 'string', dataIndex: 'scoredBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.score, debugtype: 'int', dataIndex: 'score', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.comment, debugtype: 'string', dataIndex: 'comment', width: '13',render: (text, record)=>renderTextCell(text,record)},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(scoring, targetComponent, columCount)=>{
  const displayColumnsCount = columCount || 2
  const userContext = null
  return (
    <div key={scoring.id}>
	
      <DescriptionList  key={scoring.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{scoring.id}</Description> 
        <Description term={fieldLabels.scoredBy} style={{wordBreak: 'break-all'}}>{scoring.scoredBy}</Description> 
        <Description term={fieldLabels.score}><div style={{"color":"red"}}>{scoring.score}</div></Description> 
        <Description term={fieldLabels.comment} style={{wordBreak: 'break-all'}}>{scoring.comment}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {scoredBy, score, comment} = formValuesToPack

	const data = {scoredBy, score, comment}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {scoredBy, score, comment} = objectToUnpack

	const data = {scoredBy, score, comment}
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
const ScoringBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
export default ScoringBase




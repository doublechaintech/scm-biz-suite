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
const menuData = {menuName:"评分", menuFor: "scoring",
  		subItems: [
  {name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('scoring'), menuFor: "scoring",
  		subItems: [
  {name: 'employeeCompanyTrainingList', displayName: window.mtrans('employee_company_training','scoring.employee_company_training_list',false), type:'employeeCompanyTraining',icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}


<<<<<<< HEAD
const settingMenuData = {menuName:"评分", menuFor: "scoring",
=======
const settingMenuData = {menuName: window.trans('scoring'), menuFor: "scoring",
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  		subItems: [
  
  		],
}

const fieldLabels = {
<<<<<<< HEAD
  id: '序号',
  scoredBy: '由谁打分',
  score: '分数',
  comment: '评论',
=======
  id: window.trans('scoring.id'),
  scoredBy: window.trans('scoring.scored_by'),
  score: window.trans('scoring.score'),
  comment: window.trans('scoring.comment'),
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'scoring') , sorter: true },
  { title: fieldLabels.scoredBy, debugtype: 'string', dataIndex: 'scoredBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.score, debugtype: 'int', dataIndex: 'score', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.comment, debugtype: 'string', dataIndex: 'comment', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
<<<<<<< HEAD
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(scoring,targetComponent)=>{

  const userContext = null
  return (
    <div key={scoring.id}>
	
      <DescriptionList  key={scoring.id} size="small" col="4">
        <Description term="序号">{scoring.id}</Description> 
        <Description term="由谁打分">{scoring.scoredBy}</Description> 
        <Description term="分数"><div style={{"color":"red"}}>{scoring.score}</div></Description> 
        <Description term="评论">{scoring.comment}</Description> 
	
        
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
=======


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(scoring,targetComponent)=>{

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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

	const data = {scoredBy, score, comment}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {scoredBy, score, comment} = objectToUnpack

<<<<<<< HEAD
const ScoringBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
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
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default ScoringBase




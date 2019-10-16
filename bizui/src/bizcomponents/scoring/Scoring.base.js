import React from 'react'
import { Icon,Divider } from 'antd'

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
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


const menuData = {menuName:"评分", menuFor: "scoring",
  		subItems: [
  {name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"评分", menuFor: "scoring",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  scoredBy: '由谁打分',
  score: '分数',
  comment: '评论',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'scoring') , sorter: true },
  { title: fieldLabels.scoredBy, debugtype: 'string', dataIndex: 'scoredBy', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.score, debugtype: 'int', dataIndex: 'score', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.comment, debugtype: 'string', dataIndex: 'comment', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
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

	const data = {scoredBy, score, comment}
	return data
}

const ScoringBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default ScoringBase




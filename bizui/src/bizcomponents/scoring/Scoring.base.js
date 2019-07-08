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


const menuData = {menuName:"Scoring", menuFor: "scoring",
  		subItems: [
  {name: 'employeeCompanyTrainingList', displayName:'Employee Company Training', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: 'Id',
  scoredBy: 'Scored By',
  score: 'Score',
  comment: 'Comment',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'scoring') , sorter: true },
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
<Description term="Id">{scoring.id}</Description> 
<Description term="Scored By">{scoring.scoredBy}</Description> 
<Description term="Score">{scoring.score}</Description> 
<Description term="Comment">{scoring.comment}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const ScoringBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ScoringBase




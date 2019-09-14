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


const menuData = {menuName:"人力资源部面试", menuFor: "hrInterview",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  who: '谁',
  interviewTime: '面试时间',
  comments: '评论',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'hrInterview') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.interviewTime, dataIndex: 'interviewTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.comments, debugtype: 'string', dataIndex: 'comments', width: '17',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(hrInterview,targetComponent)=>{

  const userContext = null
  return (
    <div key={hrInterview.id}>
	
      <DescriptionList  key={hrInterview.id} size="small" col="4">
        <Description term="序号">{hrInterview.id}</Description> 
        <Description term="谁">{hrInterview.who}</Description> 
        <Description term="面试时间"><div>{ moment(hrInterview.interviewTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="评论">{hrInterview.comments}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const HrInterviewBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default HrInterviewBase




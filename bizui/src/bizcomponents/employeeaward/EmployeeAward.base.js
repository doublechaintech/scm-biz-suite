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


const menuData = {menuName:"Employee Award", menuFor: "employeeAward",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  employee: 'Employee',
  completeTime: 'Complete Time',
  type: 'Type',
  remark: 'Remark',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.completeTime, dataIndex: 'completeTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeAward,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={employeeAward.id}>
	
	<DescriptionList  key={employeeAward.id} size="small" col="4">
<Description term="Id">{employeeAward.id}</Description> 
<Description term="Employee">{employeeAward.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeAward.employee.displayName}(${employeeAward.employee.id})`}
</Description>
<Description term="Complete Time">{ moment(employeeAward.completeTime).format('YYYY-MM-DD')}</Description> 
<Description term="Type">{employeeAward.type}</Description> 
<Description term="Remark">{employeeAward.remark}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const EmployeeAwardBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeAwardBase




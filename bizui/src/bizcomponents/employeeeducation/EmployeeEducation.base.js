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


const menuData = {menuName:"Employee Education", menuFor: "employeeEducation",
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
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeEducation,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={employeeEducation.id}>
	
	<DescriptionList  key={employeeEducation.id} size="small" col="4">
<Description term="Id">{employeeEducation.id}</Description> 
<Description term="Employee">{employeeEducation.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeEducation.employee.displayName}(${employeeEducation.employee.id})`}
</Description>
<Description term="Complete Time">{ moment(employeeEducation.completeTime).format('YYYY-MM-DD')}</Description> 
<Description term="Type">{employeeEducation.type}</Description> 
<Description term="Remark">{employeeEducation.remark}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const EmployeeEducationBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeEducationBase




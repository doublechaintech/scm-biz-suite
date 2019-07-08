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


const menuData = {menuName:"Employee Company Training", menuFor: "employeeCompanyTraining",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  employee: 'Employee',
  training: 'Training',
  scoring: 'Scoring',
  currentStatus: 'Current Status',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.training, dataIndex: 'training', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.scoring, dataIndex: 'scoring', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '10',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeCompanyTraining,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={employeeCompanyTraining.id}>
	
	<DescriptionList  key={employeeCompanyTraining.id} size="small" col="4">
<Description term="Id">{employeeCompanyTraining.id}</Description> 
<Description term="Employee">{employeeCompanyTraining.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeCompanyTraining.employee.displayName}(${employeeCompanyTraining.employee.id})`}
</Description>
<Description term="Training">{employeeCompanyTraining.training==null?appLocaleName(userContext,"NotAssigned"):`${employeeCompanyTraining.training.displayName}(${employeeCompanyTraining.training.id})`}
</Description>
<Description term="Current Status">{employeeCompanyTraining.currentStatus}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const EmployeeCompanyTrainingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeCompanyTrainingBase




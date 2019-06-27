import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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


const menuData = {menuName:"员工参与的公司培训", menuFor: "employeeCompanyTraining",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  employee: '员工',
  training: '训练',
  scoring: '评分',
  currentStatus: '当前状态',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.training, dataIndex: 'training', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.scoring, dataIndex: 'scoring', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '10',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({employeeCompanyTraining,targetComponent})=>{

	
	
	const {EmployeeCompanyTrainingService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{employeeCompanyTraining.id}</Description> 
<Description term="员工">{employeeCompanyTraining.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeCompanyTraining.employee.displayName}(${employeeCompanyTraining.employee.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"员工","employee",EmployeeCompanyTrainingService.requestCandidateEmployee,
	      EmployeeCompanyTrainingService.transferToAnotherEmployee,"anotherEmployeeId",employeeCompanyTraining.employee?employeeCompanyTraining.employee.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="训练">{employeeCompanyTraining.training==null?appLocaleName(userContext,"NotAssigned"):`${employeeCompanyTraining.training.displayName}(${employeeCompanyTraining.training.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"训练","companyTraining",EmployeeCompanyTrainingService.requestCandidateTraining,
	      EmployeeCompanyTrainingService.transferToAnotherTraining,"anotherTrainingId",employeeCompanyTraining.training?employeeCompanyTraining.training.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="当前状态">{employeeCompanyTraining.currentStatus}</Description> 
	
        {buildTransferModal(employeeCompanyTraining,targetComponent)}
      </DescriptionList>
	)

}
	



const EmployeeCompanyTrainingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeCompanyTrainingBase




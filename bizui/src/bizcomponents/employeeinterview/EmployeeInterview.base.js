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


const menuData = {menuName:"员工面试", menuFor: "employeeInterview",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  employee: '员工',
  interviewType: '面试类型',
  remark: '备注',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.interviewType, dataIndex: 'interviewType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '14',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({employeeInterview,targetComponent})=>{

	
	
	const {EmployeeInterviewService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{employeeInterview.id}</Description> 
<Description term="员工">{employeeInterview.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeInterview.employee.displayName}(${employeeInterview.employee.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"员工","employee",EmployeeInterviewService.requestCandidateEmployee,
	      EmployeeInterviewService.transferToAnotherEmployee,"anotherEmployeeId",employeeInterview.employee?employeeInterview.employee.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="面试类型">{employeeInterview.interviewType==null?appLocaleName(userContext,"NotAssigned"):`${employeeInterview.interviewType.displayName}(${employeeInterview.interviewType.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"面试类型","interviewType",EmployeeInterviewService.requestCandidateInterviewType,
	      EmployeeInterviewService.transferToAnotherInterviewType,"anotherInterviewTypeId",employeeInterview.interviewType?employeeInterview.interviewType.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="备注">{employeeInterview.remark}</Description> 
	
        {buildTransferModal(employeeInterview,targetComponent)}
      </DescriptionList>
	)

}
	



const EmployeeInterviewBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeInterviewBase




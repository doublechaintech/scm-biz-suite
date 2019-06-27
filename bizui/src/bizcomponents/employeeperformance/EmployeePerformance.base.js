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


const menuData = {menuName:"员工绩效", menuFor: "employeePerformance",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  employee: '员工',
  performanceComment: '绩效评价',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.performanceComment, debugtype: 'string', dataIndex: 'performanceComment', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({employeePerformance,targetComponent})=>{

	
	
	const {EmployeePerformanceService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{employeePerformance.id}</Description> 
<Description term="员工">{employeePerformance.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeePerformance.employee.displayName}(${employeePerformance.employee.id})`}
 <Icon type="swap" onClick={()=>
  showTransferModel(targetComponent,"员工","employee",EmployeePerformanceService.requestCandidateEmployee,
	      EmployeePerformanceService.transferToAnotherEmployee,"anotherEmployeeId",employeePerformance.employee?employeePerformance.employee.id:"")} 
  style={{fontSize: 20,color:"red"}} />
</Description>
<Description term="绩效评价">{employeePerformance.performanceComment}</Description> 
	
        {buildTransferModal(employeePerformance,targetComponent)}
      </DescriptionList>
	)

}
	



const EmployeePerformanceBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeePerformanceBase




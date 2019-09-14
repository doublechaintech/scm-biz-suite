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
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeePerformance') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.performanceComment, debugtype: 'string', dataIndex: 'performanceComment', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeePerformance,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeePerformance.id}>
	
      <DescriptionList  key={employeePerformance.id} size="small" col="4">
        <Description term="序号">{employeePerformance.id}</Description> 
        <Description term="员工"><div>{employeePerformance.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeePerformance.employee.displayName}(${employeePerformance.employee.id})`}
        </div></Description>
        <Description term="绩效评价">{employeePerformance.performanceComment}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const EmployeePerformanceBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeePerformanceBase




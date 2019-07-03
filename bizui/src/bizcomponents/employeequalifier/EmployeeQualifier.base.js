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


const menuData = {menuName:"员工资质", menuFor: "employeeQualifier",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  employee: '员工',
  qualifiedTime: '合格的时间',
  type: '类型',
  level: '水平',
  remark: '备注',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.qualifiedTime, dataIndex: 'qualifiedTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.type, debugtype: 'string', dataIndex: 'type', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.level, debugtype: 'string', dataIndex: 'level', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.remark, debugtype: 'string', dataIndex: 'remark', width: '13',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeQualifier,targetComponent)=>{

	
	
	
	const userContext = null
	return (
	<div key={employeeQualifier.id}>
	
	<DescriptionList  key={employeeQualifier.id} size="small" col="4">
<Description term="序号">{employeeQualifier.id}</Description> 
<Description term="员工">{employeeQualifier.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeQualifier.employee.displayName}(${employeeQualifier.employee.id})`}
</Description>
<Description term="合格的时间">{ moment(employeeQualifier.qualifiedTime).format('YYYY-MM-DD')}</Description> 
<Description term="类型">{employeeQualifier.type}</Description> 
<Description term="水平">{employeeQualifier.level}</Description> 
<Description term="备注">{employeeQualifier.remark}</Description> 
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const EmployeeQualifierBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeQualifierBase




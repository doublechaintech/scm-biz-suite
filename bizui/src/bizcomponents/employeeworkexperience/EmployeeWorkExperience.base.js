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


const menuData = {menuName:"员工工作经验", menuFor: "employeeWorkExperience",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"员工工作经验", menuFor: "employeeWorkExperience",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  employee: '员工',
  start: '开始',
  end: '结束',
  company: '公司',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeWorkExperience') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.start, dataIndex: 'start', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.end, dataIndex: 'end', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.company, debugtype: 'string', dataIndex: 'company', width: '12',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '25',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeWorkExperience,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeWorkExperience.id}>
	
      <DescriptionList  key={employeeWorkExperience.id} size="small" col="4">
        <Description term="序号">{employeeWorkExperience.id}</Description> 
        <Description term="员工"><div>{employeeWorkExperience.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeWorkExperience.employee.displayName}(${employeeWorkExperience.employee.id})`}
        </div></Description>
        <Description term="开始"><div>{ moment(employeeWorkExperience.start).format('YYYY-MM-DD')}</div></Description> 
        <Description term="结束"><div>{ moment(employeeWorkExperience.end).format('YYYY-MM-DD')}</div></Description> 
        <Description term="公司">{employeeWorkExperience.company}</Description> 
        <Description term="描述">{employeeWorkExperience.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const EmployeeWorkExperienceBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeWorkExperienceBase




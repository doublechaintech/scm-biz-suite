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


const menuData = {menuName:"员工技能", menuFor: "employeeSkill",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"员工技能", menuFor: "employeeSkill",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  employee: '员工',
  skillType: '技能类型',
  description: '描述',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employeeSkill') , sorter: true },
  { title: fieldLabels.employee, dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.skillType, dataIndex: 'skillType', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '11',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employeeSkill,targetComponent)=>{

  const userContext = null
  return (
    <div key={employeeSkill.id}>
	
      <DescriptionList  key={employeeSkill.id} size="small" col="4">
        <Description term="序号">{employeeSkill.id}</Description> 
        <Description term="员工"><div>{employeeSkill.employee==null?appLocaleName(userContext,"NotAssigned"):`${employeeSkill.employee.displayName}(${employeeSkill.employee.id})`}
        </div></Description>
        <Description term="技能类型"><div>{employeeSkill.skillType==null?appLocaleName(userContext,"NotAssigned"):`${employeeSkill.skillType.displayName}(${employeeSkill.skillType.id})`}
        </div></Description>
        <Description term="描述">{employeeSkill.description}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const EmployeeSkillBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default EmployeeSkillBase




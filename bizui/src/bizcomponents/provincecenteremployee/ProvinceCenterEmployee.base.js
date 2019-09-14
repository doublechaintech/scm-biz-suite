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


const menuData = {menuName:"省中心员工", menuFor: "provinceCenterEmployee",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  name: '名称',
  mobile: '手机',
  email: '电子邮件',
  founded: '成立',
  department: '部门',
  provinceCenter: '省中心',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'provinceCenterEmployee') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.mobile, debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '24',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.provinceCenter, dataIndex: 'provinceCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(provinceCenterEmployee,targetComponent)=>{

  const userContext = null
  return (
    <div key={provinceCenterEmployee.id}>
	
      <DescriptionList  key={provinceCenterEmployee.id} size="small" col="4">
        <Description term="序号">{provinceCenterEmployee.id}</Description> 
        <Description term="名称">{provinceCenterEmployee.name}</Description> 
        <Description term="手机">{provinceCenterEmployee.mobile}</Description> 
        <Description term="电子邮件">{provinceCenterEmployee.email}</Description> 
        <Description term="成立"><div>{ moment(provinceCenterEmployee.founded).format('YYYY-MM-DD')}</div></Description> 
        <Description term="部门"><div>{provinceCenterEmployee.department==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterEmployee.department.displayName}(${provinceCenterEmployee.department.id})`}
        </div></Description>
        <Description term="省中心"><div>{provinceCenterEmployee.provinceCenter==null?appLocaleName(userContext,"NotAssigned"):`${provinceCenterEmployee.provinceCenter.displayName}(${provinceCenterEmployee.provinceCenter.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const ProvinceCenterEmployeeBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ProvinceCenterEmployeeBase




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


const menuData = {menuName:"一级部门", menuFor: "levelOneDepartment",
  		subItems: [
  {name: 'levelTwoDepartmentList', displayName:'二级部门', icon:'dice-two',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  belongsTo: '属于',
  name: '名称',
  description: '描述',
  manager: '经理',
  founded: '成立',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelOneDepartment') , sorter: true },
  { title: fieldLabels.belongsTo, dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.description, debugtype: 'string', dataIndex: 'description', width: '22',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.manager, debugtype: 'string', dataIndex: 'manager', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.founded, dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(levelOneDepartment,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelOneDepartment.id}>
	
      <DescriptionList  key={levelOneDepartment.id} size="small" col="4">
        <Description term="序号">{levelOneDepartment.id}</Description> 
        <Description term="名称">{levelOneDepartment.name}</Description> 
        <Description term="描述">{levelOneDepartment.description}</Description> 
        <Description term="经理">{levelOneDepartment.manager}</Description> 
        <Description term="成立"><div>{ moment(levelOneDepartment.founded).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const LevelOneDepartmentBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default LevelOneDepartmentBase




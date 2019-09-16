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


const menuData = {menuName:"二级分类", menuFor: "levelTwoCategory",
  		subItems: [
  {name: 'levelThreeCategoryList', displayName:'三级分类', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}


const settingMenuData = {menuName:"二级分类", menuFor: "levelTwoCategory",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  parentCategory: '父类',
  name: '名称',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'levelTwoCategory') , sorter: true },
  { title: fieldLabels.parentCategory, dataIndex: 'parentCategory', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(levelTwoCategory,targetComponent)=>{

  const userContext = null
  return (
    <div key={levelTwoCategory.id}>
	
      <DescriptionList  key={levelTwoCategory.id} size="small" col="4">
        <Description term="序号">{levelTwoCategory.id}</Description> 
        <Description term="父类"><div>{levelTwoCategory.parentCategory==null?appLocaleName(userContext,"NotAssigned"):`${levelTwoCategory.parentCategory.displayName}(${levelTwoCategory.parentCategory.id})`}
        </div></Description>
        <Description term="名称">{levelTwoCategory.name}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const LevelTwoCategoryBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default LevelTwoCategoryBase




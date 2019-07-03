

import React, { Component } from 'react'
import FontAwesome from 'react-fontawesome';
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from 'components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './LevelThreeCategory.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (levelThreeCategory,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{levelThreeCategory.id}</Description> 
<Description term="名称">{levelThreeCategory.name}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = levelThreeCategory => {
  const {LevelThreeCategoryBase} = GlobalComponents
  return <PermissionSetting targetObject={levelThreeCategory}  targetObjectMeta={LevelThreeCategoryBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class LevelThreeCategoryPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  levelThreeCategory = this.props.levelThreeCategory;
    const { id,displayName, productCount } = levelThreeCategory
    const cardsData = {cardsName:"三级分类",cardsFor: "levelThreeCategory",cardsSource: levelThreeCategory,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={`${cardsData.cardsName}: ${displayName}`}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  levelThreeCategory: state._levelThreeCategory,
}))(Form.create()(LevelThreeCategoryPermission))




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
import styles from './OccupationType.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (occupationType,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{occupationType.id}</Description> 
<Description term="代码">{occupationType.code}</Description> 
<Description term="描述">{occupationType.description}</Description> 
<Description term="详细描述">{occupationType.detailDescription}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = occupationType => {
  const {OccupationTypeBase} = GlobalComponents
  return <PermissionSetting targetObject={occupationType}  targetObjectMeta={OccupationTypeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class OccupationTypePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  occupationType = this.props.occupationType;
    const { id,displayName, employeeCount } = occupationType
    const cardsData = {cardsName:"职位类型",cardsFor: "occupationType",cardsSource: occupationType,
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
  occupationType: state._occupationType,
}))(Form.create()(OccupationTypePermission))


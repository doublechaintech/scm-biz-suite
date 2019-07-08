

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
import styles from './PublicHoliday.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


const internalSummaryOf = (publicHoliday,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="Id">{publicHoliday.id}</Description> 
<Description term="Code">{publicHoliday.code}</Description> 
<Description term="Name">{publicHoliday.name}</Description> 
<Description term="Description">{publicHoliday.description}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = publicHoliday => {
  const {PublicHolidayBase} = GlobalComponents
  return <PermissionSetting targetObject={publicHoliday}  targetObjectMeta={PublicHolidayBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class PublicHolidayPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  publicHoliday = this.props.publicHoliday;
    const { id,displayName,  } = publicHoliday
    const cardsData = {cardsName:"Public Holiday",cardsFor: "publicHoliday",cardsSource: publicHoliday,
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
  publicHoliday: state._publicHoliday,
}))(Form.create()(PublicHolidayPermission))


using Microsoft.AspNetCore.Mvc;
using NHibernate;
using Shopking.Dao;
using Shopking.Models;
using Shopking.Models.Dto;
using Shopking.Models.Mapper;
using System;
using System.Collections.Generic;
using System.Linq;

namespace Shopking.Controllers
{
    [Route("api/recipes")]
    public class RecipeController : ControllerBase
    {
        private readonly RecipeRepository recipeRepository;

        public RecipeController(RecipeRepository recipeRepository)
        {
            this.recipeRepository = recipeRepository;
        }

        [HttpGet("{id}")]
        public IActionResult GetDetails(long id)
        {
            try {
                return Ok(RecipeMapper.map(recipeRepository.GetRecipeById(id)));
            } catch (Exception)
            {
                return BadRequest();
            }
        }

        [HttpGet]
        public IEnumerable<RecipeDto> Get([FromQuery] RecipeDifficulty? difficulty)
        {
            if (difficulty == null)
            {
                return recipeRepository.GetRecipes().Select(r => RecipeMapper.map(r));
            } else
            {
                return recipeRepository.GetRecipesByDifficulty((RecipeDifficulty)difficulty).Select(r => RecipeMapper.map(r));
            }
        }

        [HttpGet("difficulties")]
        public IList<String> GetDifficulties()
        {
            return Enum.GetValues<RecipeDifficulty>().Select(d => d.ToString()).ToList();
        }
    }
}
